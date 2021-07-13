package ru.netology.repository;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Issue;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class IssueRepositoryTest {
    private IssueRepository repository = new IssueRepository();
    HashSet<String> firstAssigneeSet = new HashSet<>(Arrays.asList("firstAssignee"));
    HashSet<String> secondAssigneeSet = new HashSet<>(Arrays.asList("secondAssignee"));
    HashSet<String> firstTagSet = new HashSet<>(Arrays.asList("firstTag"));
    HashSet<String> secondTagSet = new HashSet<>(Arrays.asList("firstTag", "secondTag"));
    Issue first = new Issue(1, "name", "body", "firstAuthor", firstAssigneeSet, true, firstTagSet);
    Issue second = new Issue(2, "name", "body", "author", secondAssigneeSet, false, secondTagSet);
    Issue third = new Issue(3, "name", "body", "author", null, true, null);

    @Test
    void shouldSetStatusById() {
        repository.add(first);
        repository.add(second);
        repository.add(third);
        boolean expected = false;
        repository.setStatusById(first.getId(), expected);
        Issue actualIssue = repository.getById(first.getId());
        boolean actual = actualIssue.isStatus();
        assertEquals(expected, actual);
    }

    @Test
    void shouldGetOpen() {
        repository.add(first);
        repository.add(second);
        repository.add(third);
        List<Issue> expected = new ArrayList<Issue>();
        expected.add(first);
        expected.add(third);
        List<Issue> actual = repository.getOpen();
        assertEquals(expected, actual);
    }

    @Test
    void shouldAddIssue() {
        repository.add(new Issue());
    }

    @Test
    void shouldGetByStatus() {
        repository.add(first);
        repository.add(second);
        repository.add(third);
        List<Issue> expected = new ArrayList<Issue>();
        expected.add(second);
        List<Issue> actual = repository.getByStatus(false);
        assertEquals(expected, actual);
    }

    @Test
    void shouldGetByAssignee() {
        String secondAssignee = "secondAssignee";
        repository.add(first);
        repository.add(second);
        repository.add(third);
        List<Issue> expected = new ArrayList<Issue>();
        expected.add(second);
        List<Issue> actual = repository.getByAssignee(secondAssignee);
        assertEquals(expected, actual);
    }

    @Test
    void shouldGetByTag() {
        String secondTag = "secondTag";
        repository.add(first);
        repository.add(second);
        repository.add(third);
        List<Issue> expected = new ArrayList<Issue>();
        expected.add(second);
        List<Issue> actual = repository.getByTag(secondTag);
        assertEquals(expected, actual);
    }

    @Test
    void shouldGetByAuthor() {
        String author = "author";
        repository.add(first);
        repository.add(second);
        repository.add(third);
        List<Issue> expected = new ArrayList<Issue>();
        expected.add(second);
        expected.add(third);
        List<Issue> actual = repository.getByAuthor(author);
        assertEquals(expected, actual);
    }

    @Test
    void shouldGetAll() {
        repository.add(first);
        repository.add(second);
        repository.add(third);
        List<Issue> expected = new ArrayList<Issue>();
        expected.add(first);
        expected.add(second);
        expected.add(third);
        List<Issue> actual = repository.getAll();
        assertEquals(expected, actual);
    }

    @Test
    void shouldGetByIdExist() {
        repository.add(first);
        repository.add(second);
        repository.add(third);
        Issue expected = first;
        int id = first.getId();
        Issue actual = repository.getById(id);
        assertEquals(expected, actual);
    }

    @Test
    void shouldGetByIdNoneExist() {
        repository.add(first);
        repository.add(second);
        repository.add(third);
        Issue expected = null;
        Issue actual = repository.getById(0);
        assertEquals(expected, actual);
    }

    @Test
    void shouldRemove() {
        repository.add(first);
        repository.add(second);
        repository.add(third);
        repository.remove(third);
        List<Issue> expected = new ArrayList<Issue>();
        expected.add(first);
        expected.add(second);
        List<Issue> actual = repository.getAll();
        assertEquals(expected, actual);
    }
}

