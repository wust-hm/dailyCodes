package zhong.test202011.test1119.static_proxy;

/**
 * @author zhong
 * @description
 * @date 2020/11/19 12:00
 * @motto talk is cheap, show me your code!
 */
public class RealMovie implements Movie{
    @Override
    public void play() {
        System.out.println("您正在观看电影《变形金刚》");
    }
}
