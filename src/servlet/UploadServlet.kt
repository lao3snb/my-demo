package servlet

import javax.servlet.annotation.MultipartConfig
import javax.servlet.annotation.WebServlet
import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

/**
 * 文件上传
 *      使用注解@MultipartConfig将一个Servlet声明为支持文件上传
 *      Servlet将multipart/form-data的请求封装成Part，通过Part对上传的文件进行操作
 *          Part part = request.getPart(name);
 *          name 代表表单元素（文件域）的name属性值
 */

@MultipartConfig // 文件上传必须声明此注解，否则所有参数无法获取
@WebServlet("/uploadServlet")
class UploadServlet : HttpServlet() {
    override fun service(req: HttpServletRequest?, resp: HttpServletResponse?) {
        // 设置请求的编码格式
        req?.characterEncoding = "utf-8"

        // 获取普通文本框
        val uname = req?.getParameter("uname")
        println("用户名：$uname")

        // 得到Part对象
        var part = req?.getPart("myfile")
        // 得到上传文件的文件名
        var fileName = part?.submittedFileName

        // 设置上传的文件要存放的路径
        var uploadPath = req?.servletContext?.getRealPath("/upload/")
        // 上传文件
//        println("$uploadPath$fileName")
        part?.write("$uploadPath$fileName")
    }
}