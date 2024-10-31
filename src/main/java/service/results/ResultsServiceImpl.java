package service.results;

import domain.results.Results;
import repository.results.ResultsRepository;

import java.util.List;

public class ResultsServiceImpl implements ResultsService {

    private final ResultsRepository resultsRepository;

    public ResultsServiceImpl(ResultsRepository resultsRepository) {
        this.resultsRepository = resultsRepository;
    }

    @Override
    public void makeResults(List<String> results) {
        resultsRepository.setResults(new Results(results));
    }

    @Override
    public Results getResults() {
        return resultsRepository.getResults();
    }
}
