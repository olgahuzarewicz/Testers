package com.interview.app.service;

import com.interview.app.dto.TesterDTO;
import com.interview.app.model.Bug;
import com.interview.app.model.Tester;
import lombok.AllArgsConstructor;
import org.apache.commons.collections.CollectionUtils;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@AllArgsConstructor
public class TesterService {

    private List<Tester> testers;
    private List<Bug> bugs;

    public List<TesterDTO> getTesters(List<String> countryNames, List<Integer> deviceIds) {

        Stream<Tester> testersStream = testers.stream();

        if (countryNames != null) {
            testersStream = testersStream.filter(tester -> countryNames.contains(tester.getCountry()));
        }

        if (deviceIds != null) {
            testersStream = testersStream.filter(tester -> CollectionUtils.containsAny(tester.getDeviceIds(), deviceIds));
        }

        List<TesterDTO> testerDTOS = testersStream.map(tester -> {
            long experience = deviceIds != null ? countTesterExperience(tester.getId(), deviceIds) : countTesterExperience(tester.getId());
            return new TesterDTO(tester.getId(), tester.getFirstName(), tester.getLastName(), experience);
        }).collect(Collectors.toList());

        testerDTOS.sort(Comparator.comparing(TesterDTO::experience, Comparator.reverseOrder()));
        return testerDTOS;
    }

    private long countTesterExperience(int testerId) {
        return bugs.stream().filter(bug -> bug.getTesterId() == testerId).count();
    }

    private long countTesterExperience(int testerId, List<Integer> devices) {
        return bugs.stream().filter(bug -> bug.getTesterId() == testerId && devices.contains(bug.getDeviceId())).count();
    }
}
