package com.universityonline.repositories;

import com.universityonline.domain.entities.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;


@Transactional
public class PersonRepository {

    @Autowired
    private HibernateTemplate hibernateTemplate;

    public void saveOrUpdate(Person person) {
        hibernateTemplate.saveOrUpdate(person);
    }


    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }
}
