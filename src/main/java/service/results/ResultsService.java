package service.results;

import domain.results.Results;

import java.util.List;

public interface ResultsService {
    void makeResults(final List<String> results);

    Results getResults();
}
