package xiangmuzhou.zhoukao.ypu.zhoukaoyipengyu.bean;

import org.xutils.db.annotation.Column;
import org.xutils.db.annotation.Table;

/**
 * date : ${Data}
 * author:衣鹏宇(ypu)
 */
@Table(name = "Users",onCreated = "")
public class Users {
    /**
     * name = "id"：数据库表中的一个字段
     * isId = true：是否是主键
     * autoGen = true：是否自动增长
     * property = "NOT NULL"：添加约束
     */
    @Column(name = "id",isId = true,autoGen = true,property = "NOT NULL")
    private int id;
    @Column(name = "c_name")
    private String cName;

    public Users(String cName) {
        this.cName = cName;
    }
    public Users(){

    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getcName() {
        return cName;
    }
    public void setcName(String cName) {
        this.cName = cName;
    }
    @Override
    public String toString() {
        return "ChildInfo{"+"id="+id+",cName='"+cName+'\''+'}';
    }
}
