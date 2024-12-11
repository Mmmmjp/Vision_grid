package model;

import dao.VisionSetDAO;

public class VisionSetLogic {

    /**
     * @param vision VisionBeansオブジェクト
     * @return 生成されたVISION_ID
     */
    public int execute(VisionBeans vision) {
        // 戻り値の準備
        int visionId = 0;

        VisionSetDAO dao = new VisionSetDAO();
        try {
            visionId = dao.setVision(vision);
        } catch (Exception e) {
            e.printStackTrace(); 
        }

        return visionId;
    }
}

