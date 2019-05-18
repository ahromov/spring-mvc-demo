package ua.lviv.lgs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.lviv.lgs.domain.Participant;
import ua.lviv.lgs.repo.ParticipantRepo;

@Service
public class ParticipantService {

	@Autowired
	private ParticipantRepo participantRepo;

	public List<Participant> findAllParticipants() {
		return participantRepo.findAllParticipants();
	}

	public Participant findOne(int id) {
		return participantRepo.findOne(id);
	}

	public void save(Participant book) {
		participantRepo.save(book);
	}

	public void delete(int id) {
		participantRepo.delete(id);
	}

}
