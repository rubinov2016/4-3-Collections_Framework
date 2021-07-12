package ru.netology.manager;

import ru.netology.domain.Issue;
import ru.netology.repository.IssueRepository;

import java.util.List;

public class IssueManager {
    private IssueRepository repository;

    public IssueManager(IssueRepository repository) {
        this.repository = repository;
    }

    public void add(Issue issue) {
        repository.add(issue);
    }

    public void remove(Issue issue) {
        repository.remove(issue);
    }

    public void getAll(Issue issue) {
        repository.getAll();
    }

    public Issue getById(int id) {
        Issue issue = repository.getById(id);
        return issue;
    }

    public List<Issue> getByStatus(boolean status) {
        List<Issue> issue = repository.getByStatus(status);
        return issue;
    }

    public List<Issue> getByAuthor(String author) {
        List<Issue> issue = repository.getByAuthor(author);
        return issue;
    }

    public List<Issue> getByAssignee(String name) {
        List<Issue> issue = repository.getByAssignee(name);
        return issue;
    }

    public List<Issue> getByTag(String name) {
        List<Issue> issue = repository.getByTag(name);
        return issue;
    }

}
