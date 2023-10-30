package com.example.rubrica.rubrica.service;

import com.example.rubrica.rubrica.entity.ToDoList;
import com.example.rubrica.rubrica.repository.ToDoListRepo;
import com.example.rubrica.rubrica.util.DateCheck;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class ToDoListService {

	@Autowired
	ToDoListRepo toDoListRepo;

	public List<ToDoList> getAll(){
		return toDoListRepo.findAll();
	}

	public ToDoList addTask(ToDoList task){
		return toDoListRepo.save(task);
	}

	public ToDoList editTask(ToDoList task){
		return toDoListRepo.save(task);
	}

	public void deleteTask(Long id){
		toDoListRepo.deleteById(id);
	}

	public ToDoList getTask(Long id){
		Optional<ToDoList> opt = toDoListRepo.findById(id);
		return opt.orElse(null);
	}

	public List<ToDoList> genericSearch(String nameToDo, String creationDate, String expiredDate) {

		LocalDate cDate = DateCheck.isDate(creationDate != null ? creationDate.trim() : null) ? LocalDate.parse(creationDate.trim()) : null;
		LocalDate eDate = DateCheck.isDate(expiredDate != null ? expiredDate.trim() : null) ? LocalDate.parse(expiredDate.trim()) : null;

		return search(nameToDo, cDate, eDate);
	}

	public List<ToDoList> search(String nameToDo, LocalDate cDate, LocalDate eDate) {

		boolean nameToDoCheck = nameToDo != null && !nameToDo.trim().isEmpty();
		boolean creationDateCheck = cDate != null;
		boolean expiredDateCheck = eDate != null;

		if (nameToDoCheck && creationDateCheck && expiredDateCheck)	return toDoListRepo.findByNameToDoAndCreationDateAndExpiredDate(nameToDo, cDate, eDate);
		if (nameToDoCheck && creationDateCheck) return toDoListRepo.findByNameToDoAndCreationDate(nameToDo, cDate);
		if (nameToDoCheck && expiredDateCheck) return toDoListRepo.findByNameToDoAndExpiredDate(nameToDo, eDate);
		if (creationDateCheck && expiredDateCheck) return toDoListRepo.findByCreationDateAndExpiredDate(cDate, eDate);
		if (nameToDoCheck) return toDoListRepo.findByNameToDo(nameToDo);
		if (creationDateCheck) return toDoListRepo.findByCreationDate(cDate);
		if (expiredDateCheck) return toDoListRepo.findByExpiredDate(eDate);
		return getAll();
	}

//	public List<ToDoList> search2(String nameToDo, LocalDate creationDate, LocalDate expiredDate) {
//		StringBuilder queryString = new StringBuilder();
//		boolean nameToDoCheck = false;
//		boolean creationDateCheck = false;
//		boolean expiredDateCheck = false;
//
//		if (nameToDo != null && !nameToDo.trim().isEmpty()) {
//			nameToDoCheck = true;
////			queryString.append("nameToDo = " + nameToDo.trim());
//		}
//		if (creationDate != null) {
//			if (queryString.isEmpty()) queryString.append("creationDate = " + creationDate.toString());
//			queryString.append(" AND creationDate = " + creationDate.toString());
//		}
//		if (expiredDate != null) {
//			if (queryString.isEmpty()) queryString.append("expiredDate = " + expiredDate.toString());
//			queryString.append(" AND expiredDate = " + expiredDate.toString());
//		}
//
//
//		String query = queryString.toString();
//
//		if (query.isEmpty()) return this.getAll();
////		return toDoListRepo.search(query);
//		return this.getAll();
//	}


}
