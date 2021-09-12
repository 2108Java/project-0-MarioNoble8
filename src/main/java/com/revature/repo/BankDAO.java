package com.revature.repo;

//import com.revature.models.ToDoItem;

public interface BankDAO {
	

		ToDoItem[] selectAllToDos();

		boolean insertToDo(ToDoItem newToDo);

		ToDoItem[] getAllIncompleteTodos();

		boolean deleteToDo(int deleteId);

		boolean updateToDo(int id);

	}
}
