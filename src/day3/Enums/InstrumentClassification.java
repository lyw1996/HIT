package day3.Enums;

/**
 * @author : liuyuwei
 * @date : 2020-08-26 20:43
 * 分类
 **/

public enum  InstrumentClassification {

        //分类枚举
        GAMEBOOK, LIGHTBOOK,COMMONBOOk;

        public String toString() {
            switch(this) {
                case GAMEBOOK: return "游戏笔记本";
                case LIGHTBOOK: return "轻薄笔记本";
                case COMMONBOOk: return "常规笔记本";
                default:       return "unspecified";
            }
        }

}
