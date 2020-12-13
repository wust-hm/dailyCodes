package zhong.test202012.test1207;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhong
 * @description
 * @date 2020/12/7 15:31
 * @motto talk is cheap, show me your code!
 */
public class JVMOutOfMemory {

    static class myClass{

    }

    public static void main(String[] args) {
        List<myClass> list = new ArrayList<>(3000);
        while (true){
            list.add(new myClass());
        }
    }
}
