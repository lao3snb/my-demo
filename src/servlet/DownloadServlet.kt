package servlet

import java.io.File
import java.io.FileInputStream
import javax.servlet.annotation.WebServlet
import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

/**
 * 文件下载：
 *      1. 需要通过response.setContentType方法设置Content-type头字段的值，为浏览器无法使用某种方式或激活某个程序来处理
 *          的MIME类型，例如："application/octet-stream"或"application/x-msdownload"等。
 *      2. 需要通过response.setHeader方法设置Content-Disposition头的值为"attachment;filename=文件名"。
 *      3. 读取下载文件，调用response.getOutputStream方法向客户端写入附件内容。
 * 下载步骤：
 *      1. 得到需要下载的文件名
 *      2. 得到下载文件的存放路径
 *      3. 通过路径与文件名得到file对象（要下载的文件）
 *      4. 判断file对象是否存在，且是一个标准文件
 *      5. 设置响应类型（浏览器无法使用某种方式或激活某个程序来处理的MIME类型）
 *      6. 设置响应头（下载文件名等）
 *      7. 得到要下载的文件的输入流
 *      8. 得到字节输出流
 *      9. 循环输出
 *      10. 关闭流
 */

@WebServlet("/downloadServlet")
class DownloadServlet : HttpServlet() {
    override fun service(req: HttpServletRequest?, resp: HttpServletResponse?) {

        val fileName = req?.getParameter("fileName")
        val filePath = req?.servletContext?.getRealPath("/upload/")
        val file = File("$filePath$fileName")
        if (file.exists() && file.isFile) {
            resp?.contentType = "application/x-msdownload"
            resp?.setHeader("Content-Disposition", "attachment;filename=$fileName")
            val input = FileInputStream(file)
            val output = resp?.outputStream
            var len = 0
            val bytes = ByteArray(1024)
            while (true) {
                len = input.read(bytes)
                if (len == -1) break;
                output?.write(bytes, 0, len)
            }
            output?.close()
            input?.close()
        } else {
            resp?.contentType = "text/html;charset=UTF-8"
            resp?.writer?.write("<h2>要下载的文件不存在！</h2>")
            resp?.writer?.close()
        }
    }
}