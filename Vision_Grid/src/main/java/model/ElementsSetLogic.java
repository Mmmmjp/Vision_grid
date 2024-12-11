package model;

import java.util.List;

import dao.ElementsSetDAO;

public class ElementsSetLogic {

    public List<Integer> execute(List<ElementBeans> elementsList) {
        if (elementsList == null || elementsList.isEmpty()) {
            throw new IllegalArgumentException("The elements list cannot be null or empty.");
        }

        ElementsSetDAO dao = new ElementsSetDAO();

        try {
            // DAOを使用して要素をデータベースに保存し、生成されたIDを取得
            List<Integer> elementIdsList = dao.setElements(elementsList);

            if (elementIdsList == null || elementIdsList.size() != elementsList.size()) {
                throw new RuntimeException("The number of generated IDs does not match the number of elements.");
            }

            return elementIdsList;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("An error occurred while saving elements.", e);
        }
    }
}
