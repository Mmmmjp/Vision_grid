package model;

import java.util.List;

import dao.ActionsSetDAO;

public class ActionsSetLogic {

	public Boolean execute(List<ActionBeans> actionsList) {
		
		ActionsSetDAO dao = new ActionsSetDAO();

		try {
			Boolean result = dao.setActions(actionsList);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("An error occurred while saving actions.", e);
        }
    }
}
