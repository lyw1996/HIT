package day3.Enums;

/**
 * @author : liuyuwei
 * @date : 2020-08-26 18:22
 * 类型
 **/
public enum InstrumentClass {
    // 电脑类型枚举 笔记本、台式机、服务器

    LAPTOP, DESKTOP,SERVER;
    @Override
    public String toString() {
        switch(this) {
            case LAPTOP: return "笔记本电脑";
            case DESKTOP: return "台式机";
            case SERVER: return "服务器";
            default:       return "unspecified";
        }
    }
}
