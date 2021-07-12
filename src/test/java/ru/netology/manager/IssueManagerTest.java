package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Issue;
import ru.netology.repository.IssueRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class IssueManagerTest {
    HashSet<String> firstAssigneeSet = new HashSet<>(Arrays.asList("firstAssignee"));
    HashSet<String> secondAssigneeSet = new HashSet<>(Arrays.asList("secondAssignee"));
    HashSet<String> firstTagSet = new HashSet<>(Arrays.asList("firstTag"));
    HashSet<String> secondTagSet = new HashSet<>(Arrays.asList("firstTag", "secondTag"));
    Issue first = new Issue(1, "name", "body", "firstAuthor", firstAssigneeSet, true, firstTagSet);
    Issue second = new Issue(2, "name", "body", "author", secondAssigneeSet, false, secondTagSet);
    Issue third = new Issue(3, "name", "body", "author", null, true, null);

    @Test
    void shouldGetByAssignee() {
        IssueRepository repository = new IssueRepository();
        IssueManager manager = new IssueManager(repository);
        String secondAssignee = "secondAssignee" ;
        manager.add(first);
        manager.add(second);
        manager.add(third);
        List<Issue> expected = new ArrayList<Issue>();
        expected.add(second);
        List<Issue> actual = manager.getByAssignee(secondAssignee);
        assertEquals(expected, actual);
    }
}
