package model;

import dao.VisionFetchDAO;

public class VisionFetchLogic {

    public VisionBeans getVisionByUserId(int userId) {
        VisionFetchDAO dao = new VisionFetchDAO();
        VisionBeans vision = dao.getVisionByUserId(userId);

        if (vision == null) {
            // データが見つからない場合は、例外を投げずに null を返す
            return null;
        }
        return vision;
    }
}
