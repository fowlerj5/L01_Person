import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PersonTest {

    Person p;

    @BeforeEach
    void setUp() {
        p = new Person("000001", "Jeremiah", "Fowler", "Mr.",2004);
    }

    @Test
    void toCSVDataRecord() {
        assertEquals("000001, Jeremiah, Fowler, Mr., 2004", p.toCSVDataRecord());
    }

    @Test
    void fullName() {
        assertEquals("Jeremiah Fowler", p.fullName());
    }

    @Test
    void formalName() {
        assertEquals("Mr. Jeremiah Fowler", p.formalName());
    }

    @Test
    void setIDnum() {
        p.setIDnum("000009");
        assertEquals("000009", p.getIDnum());
    }

    @Test
    void setFirstName() {
        p.setFirstName("Paul");
        assertEquals("Paul", p.getFirstName());
    }

    @Test
    void setLastName() {
        p.setLastName("McCartney");
        assertEquals("McCartney",p.getLastName());
    }

    @Test
    void setTitle() {
        p.setTitle("Sir");
        assertEquals("Sir", p.getTitle());
    }

    @Test
    void setYOB() {
        p.setYOB(1942);
        assertEquals(1942, p.getYOB());
    }
}
