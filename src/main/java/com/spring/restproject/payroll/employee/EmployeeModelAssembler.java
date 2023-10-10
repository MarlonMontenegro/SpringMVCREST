package com.spring.restproject.payroll.employee;


import com.spring.restproject.payroll.employee.Employee;
import com.spring.restproject.payroll.employee.EmployeeController;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;


@Component
class EmployeeModelAssembler implements RepresentationModelAssembler<Employee, EntityModel<Employee>> {

    @Override
    public EntityModel<Employee> toModel(Employee employee) {

        EntityModel<Employee> employeeModel = EntityModel.of(employee,
                linkTo(methodOn(EmployeeController.class).one(employee.getId())).withSelfRel());

        employeeModel.add(linkTo(methodOn(EmployeeController.class).all()).withRel("employees"));

        return employeeModel;


    }

}


