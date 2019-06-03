import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SymptomTest {

    @Test
    void valueTest() {
        Symptom s = new Symptom(5);
        assertEquals(5, s.getVisibility());
    }
}