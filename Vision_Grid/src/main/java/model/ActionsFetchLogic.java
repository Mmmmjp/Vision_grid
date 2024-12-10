package model;

import java.util.List;

import dao.ActionsFetchDAO;

public class ActionsFetchLogic {

	public List<ActionBeans> getActionsByElementIds(List<Integer> elementIdsList){
		
		ActionsFetchDAO dao = new ActionsFetchDAO();
		
		List<ActionBeans> actionsList =
		dao.getActionsByElementIds(elementIdsList);
		
		return actionsList;	
	}
}
