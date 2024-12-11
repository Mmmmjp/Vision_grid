package model;

import java.util.ArrayList;
import java.util.List;

import dao.ElementsFetchDAO;

public class ElementsFetchLogic {

	public List<ElementBeans> getElementsByVisionId(int visionId){
		
		ElementsFetchDAO dao = new ElementsFetchDAO();
		List<ElementBeans> elementsList = dao.getElementsByVisionId(visionId);
	
		return elementsList;
	}
	
	public List<String> getElementKeysByVisionId(int visionId) {

        ElementsFetchDAO dao = new ElementsFetchDAO();
        List<ElementBeans> elementsList = dao.getElementsByVisionId(visionId);

        // ElementBeansからキーのみを抽出
        List<String> elementKeys = new ArrayList<>();
        for (ElementBeans element : elementsList) {
            elementKeys.add(element.getElementKey());
        }

        return elementKeys;
    }
}


