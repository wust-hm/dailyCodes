package zhong.test1119.static_proxy;

/**
 * @author zhong
 * @description
 * @date 2020/11/19 12:01
 * @motto talk is cheap, show me your code!
 */
public class Cinema implements Movie{

    RealMovie realMovie;


    public Cinema(RealMovie realMovie) {
        super();
        this.realMovie = realMovie;
    }

    @Override
    public void play() {
        playAds(true);
        realMovie.play();
        playAds(false);
    }

    /**
     * 播放广告
     * @param isStart
     */
    public void playAds(boolean isStart){
        if (isStart) {
            System.out.println("电影开始了。啤酒饮料矿泉水，花生瓜子八宝粥，来，腿收一下！");
        } else {
            System.out.println("电影结束了。请大家带好自己的随身垃圾，请不要乱丢！");
        }
    }
}
