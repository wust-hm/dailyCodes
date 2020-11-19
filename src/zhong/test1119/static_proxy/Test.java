package zhong.test1119.static_proxy;

/**
 * @author zhong
 * @description
 * @date 2020/11/19 12:06
 * @motto talk is cheap, show me your code!
 */
public class Test {
    public static void main(String[] args) {
        RealMovie realMovie = new RealMovie();
        Movie movie = new Cinema(realMovie);
        movie.play();
    }
}
