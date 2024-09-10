import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class TodosTest {
    @Test
    public void shouldAddThreeTasksOfDifferentType() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {simpleTask, epic, meeting};
        Task[] actual = todos.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindMatchSimpleTask() {

        SimpleTask simpleTask = new SimpleTask(5,"Позвонить родителям");

        boolean actual = simpleTask.matches("Позвонить родителям");
        boolean expected = true;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldNotFindMatchSimpleTask() {

        SimpleTask simpleTask = new SimpleTask(5,"Позвонить родителям");

        boolean actual = simpleTask.matches("Написать другу");
        boolean expected = false;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldFindMatchMeetingProject() {


        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        boolean actual = meeting.matches("Приложение НетоБанка");
        boolean expected = true;

        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void shouldFindMatchMeetingTopic() {


        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        boolean actual = meeting.matches("Выкатка 3й версии приложения");
        boolean expected = true;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldNotFindMatchMeeting() {


        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        boolean actual = meeting.matches("sber app");
        boolean expected = false;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldFindMatchEpic() {

        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55,subtasks);

        boolean actual = epic.matches("Яйца");
        boolean expected = true;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldNotFindMatchEpic() {

        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55,subtasks);

        boolean actual = epic.matches("Пиво");
        boolean expected = false;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldFindMatchTodoEpic() {

        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);


        Task[] expected = {epic};
        Task[] actual = todos.search("Молоко");
        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldFindMatchTodoEpicAndSimple() {

        SimpleTask simpleTask = new SimpleTask(5, "Хлеб всему голова");

        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);


        Task[] expected = {simpleTask, epic};
        Task[] actual = todos.search("Хлеб");
        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldNotFindMatchTodo() {

        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);


        Task[] expected = {};
        Task[] actual = todos.search("Роза");
        Assertions.assertArrayEquals(expected, actual);

    }

}

