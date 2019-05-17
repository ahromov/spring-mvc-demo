package ua.lviv.lgs.repo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Repository;

import ua.lviv.lgs.domain.Participant;

@Repository
public class ParticipantRepo {

    private List<Participant> participants = new ArrayList<>();

    @PostConstruct
    public void init() {
	Participant participant = new Participant();
	participant.setId(1);
	participant.setName("Hooligan");
	participant.setPrimarySkill("Pc using skills");

	Participant participant2 = new Participant();
	participant2.setName("Hooligan 2");
	participant2.setId(2);
	participant2.setLevel("L2");
	participant2.setPrimarySkill("Strong pc using skills");

	Participant participant3 = new Participant();
	participant3.setName("Hooligan 3");
	participant3.setId(3);
	participant2.setLevel("L3");
	participant3.setPrimarySkill("Proffessional pc using skills");

	participants.add(participant);
	participants.add(participant2);
	participants.add(participant3);
    }

    public List<Participant> findAllParticipants() {
	return participants;
    }

    public Participant findOne(int id) {
	return participants.stream().filter(participant -> participant.getId() == id).findFirst().orElse(null);
    }

    public void save(Participant p) {
	Participant updatedParticipant = null;

	if (p.getId() != null) {
	    updatedParticipant = findOne(p.getId());
	    int index = participants.indexOf(updatedParticipant);
	    updatedParticipant.setName(p.getName());
	    updatedParticipant.setLevel(p.getLevel());
	    participants.set(index, updatedParticipant);
	} else {
	    p.setId(participants.size() + 1);
	    participants.add(p);
	}
	
    }

    public void delete(int id) {
	Iterator<Participant> iter = participants.iterator();
	while (iter.hasNext()) {
	    if (iter.next().getId() == id) {
		iter.remove();
	    }
	}
    }

}
