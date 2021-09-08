package duke;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TaskTest {
    @Test
    public void eventTest() {
        Event firstEvent = new Event("project meeting", "Aug 26 2021 19:15");
        Event secondEvent = new Event("project meeting", "Aug 26 2021 19:15");
        secondEvent.setDone();
        assertEquals(false, firstEvent.equals(secondEvent));
    }

    @Test
    public void deadlineTest() {
        Deadline firstDeadline = new Deadline("return book", "2021-08-27");
        Deadline secondDeadline = new Deadline("return book", "2021-08-27");
        assertEquals(true, firstDeadline.equals(secondDeadline));
    }

    @Test
    public void toDoTest() {
        ToDo firstToDo = new ToDo("todo borrow book");
        ToDo secondToDo = new ToDo("todo borrow book");
        assertEquals(true, firstToDo.equals(secondToDo));
    }

}
