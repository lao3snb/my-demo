package servlet

import javax.servlet.annotation.WebServlet
import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

/**
 * ServletContext对象
 *      每一个web应用有且只有一个servletContext对象，又称为Application
 *      1. ServletContext对象的获取
 *          通过request对象获取
 *          通过session获取
 *          通过servletConfig对象获取
 *          在Servlet类中直接获取
 *      2. 常用方法
 *          获取项目在服务器中的真实路径    getRealPath()
 *          获取当前服务器的版本信息    getServerInfo()
 *      3. ServletContext作用域
 *          在整个应用程序中有效，服务器关闭失效
 *          setAttribute()
 *          getAttribute()
 *          removeAttribute()
 */

@WebServlet("/sr01")
class ServletContext01 : HttpServlet() {
    override fun service(req: HttpServletRequest?, resp: HttpServletResponse?) {
        // ServletContext的获取
        // 通过request对象获取
        val servletContext01 = req?.servletContext
        // 通过session获取
        val servletContext02 = req?.session?.servletContext
        // 通过servletConfig对象获取
        val servletContext03 = servletConfig?.servletContext
        // 在Servlet类中直接获取
        val servletContext04 = servletContext

        println("项目在服务器中的真实路径：${servletContext01?.getRealPath("/")}")
        println("获取当前服务器的版本信息：${servletContext01?.serverInfo}")
    }
}