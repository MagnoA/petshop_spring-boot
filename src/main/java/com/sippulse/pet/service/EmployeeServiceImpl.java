package com.sippulse.pet.service;

import com.sippulse.pet.entity.Employee;
import com.sippulse.pet.entity.Schedule;
import com.sippulse.pet.repository.EmployeeRepository;
import com.sippulse.pet.repository.ScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private ScheduleRepository scheduleRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Employee employee = Optional.ofNullable(employeeRepository.findByEmail(email))
                .orElseThrow(()-> new UsernameNotFoundException("User not found"));
        List<GrantedAuthority> authoritiesListEmployee = AuthorityUtils.createAuthorityList(employee.getRole());
        return new User(employee.getName(), employee.getPassword(), authoritiesListEmployee);
    }

    @Override
    public Employee addEmployee(Employee employee) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        employee.setPassword(passwordEncoder.encode(employee.getPassword()));
        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> listEmployee() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee showEmployee(Long id) {
        return employeeRepository.findById(id);
    }

    @Override
    public Employee showEmployee(String email) {
        return employeeRepository.findByEmail(email);
    }

    @Override
    public Employee updateEmployee(Employee employee) {

        Employee employeeToUpdate = employeeRepository.findByEmail(employee.getEmail());

        if(employee.getEmail() != null)
            employeeToUpdate.setEmail(employee.getEmail());

        if(employee.getName() != null)
            employeeToUpdate.setName(employee.getName());

        if(employee.getRole() != null)
            employeeToUpdate.setRole(employee.getRole());

        if(employee.getPassword() != null) {
            BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            employeeToUpdate.setPassword(passwordEncoder.encode(employee.getPassword()));
        }

        return employeeRepository.save(employeeToUpdate);
    }

    @Override
    public void deteleEmployeeById(Long id) {
        Iterator<Schedule> scheduleIterator = scheduleRepository.findByEmployee_Id(id).iterator();
        while (scheduleIterator.hasNext()){
            Schedule schedule = scheduleIterator.next();
            scheduleRepository.delete(schedule.getId());
        }
        employeeRepository.delete(id);
    }
}
