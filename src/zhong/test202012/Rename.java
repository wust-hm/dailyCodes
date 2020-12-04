package zhong.test202012;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author zhong
 * @description
 * @date 2020/12/1 19:48
 * @motto talk is cheap, show me your code!
 */
public class Rename {
    public static void main(String args[]){
//        "F:\\14349\\桌面\\temp\\2020-12-4"
        String dir = "F:"+ File.separator+"14349"+ File.separator+"桌面"+ File.separator+"temp"+ File.separator+"2020-12-4";
//        String dir="F:"+ File.separator+"java";
        File file=new File(dir);
        String srcSuffix="jpg";
        String dstSuffix="jpg";
//        找到符合的jpg文件
        List<String> paths=listPath(file,srcSuffix);
        int i = 0;
        for(String path : paths){
            File srcFile=new File(path);
            String name=srcFile.getName();
            int idx=name.lastIndexOf(".");
            Integer prefix=Integer.parseInt(name.substring(0, idx)) - 200;
            System.out.println(srcFile.getParent());

            File dstFile=new File(srcFile.getParent()+"/"+prefix+"."+dstSuffix);
            if(dstFile.exists()){
                srcFile.delete();
                continue;
            }
            srcFile.renameTo(dstFile);
        }
    }

    /**
     * 获取指定路径下的所有符合条件的路径
     * @param path 路径
     * @param srcSuffix 后缀名
     * @return
     */
    private static List<String> listPath(File path, String srcSuffix) {
        List<String> list=new ArrayList<String>();
        File[] files=path.listFiles();
//        Arrays.sort(files);
        for(File file : files){
            // 如果是目录
            if(file.isDirectory()){

                /**
                 * 关键是理解以下两步操作(递归判断下级目录)
                 */
                // 递归调用
                List<String> _list= listPath(file, srcSuffix);
                //将集合添加到集合中
                list.addAll(_list);
            }else{
                //不是目录
                String name=file.getName();
                int idx=name.lastIndexOf(".");
                String suffix=name.substring(idx+1);
                if(suffix.equals(srcSuffix)){
                    //把文件的决定路径添加到集合中
                    list.add(file.getAbsolutePath());
                }
            }
        }
        return list;
    }

}
