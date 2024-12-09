package model;

import java.util.List;

import dao.ElementsFetchDAO;

public class ElementsFetchLogic {

	public List<ElementBeans> getElementsByVisionId(int visionId){
		
		ElementsFetchDAO dao = new ElementsFetchDAO();
		List<ElementBeans> elementsList = dao.getElementsByVisionId(visionId);
	
		return elementsList;
	}
}
