import com.universityonline.configuration.AppConfig;
import com.universityonline.domain.entities.*;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@ContextConfiguration(classes = AppConfig.class)
@RunWith(SpringJUnit4ClassRunner.class)
@Rollback(value = false)
public class simpleTest {

    @Autowired
    private HibernateTemplate hibernateTemplate;

    @Test
    public void test() {
        Assert.assertNotNull(hibernateTemplate);
        hibernateTemplate.setCheckWriteOperations(false);



        Professor professor = new Professor("Jan", "Kowalski", "JanKowalski", "password", "1992-10-12" , "jan.kowalski@gmail.com");
        Student student = new Student("Jan", "Kowalski", "JanKowalski", "password", "1992-10-12" , "jan.kowalski@gmail.com");
        Doctor doctor = new Doctor("Jan", "Kowalski", "JanKowalski", "password", "1992-10-12" , "jan.kowalski@gmail.com");

        Course WDI = new Course();
        WDI.setName("WDI");
        WDI.setDescription("WDI");
        hibernateTemplate.saveOrUpdate(WDI);

        professor.getCourses().add(WDI);

        student.getCourses().add(WDI);
        WDI.getStudents().add(student);
        hibernateTemplate.saveOrUpdate(professor);
        hibernateTemplate.saveOrUpdate(student);
        hibernateTemplate.saveOrUpdate(doctor);

        Course course1 = new Course();
        course1.setName("matematyka");
        course1.setDescription("matematyka");
        course1.setProfessor(professor);

        Course course2 = new Course();
        course2.setName("TJA");
        course2.setDescription("TJA");
        course2.setProfessor(professor);


        hibernateTemplate.saveOrUpdate(course1);
        hibernateTemplate.saveOrUpdate(course2);

//        List<Professor> professorDbList = hibernateTemplate.findByExample(Professor.class);
        List<Professor> professorDbList = hibernateTemplate.loadAll(Professor.class);
        Assert.assertEquals(1, professorDbList.size());
        Assert.assertEquals(2, hibernateTemplate.load(Professor.class, 1L).getCourses().size());
    }
}
