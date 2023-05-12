package cn.yunji.user.management2.filter;

import cn.yunji.user.management2.model.User;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginFilter implements Filter { // 实现Filter接口，定义一个登录过滤器类。

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // 初始化过滤器时调用该方法，可以在这里做一些配置或初始化工作。
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        // 过滤器执行时调用该方法，可以在这里做一些拦截或放行的逻辑。
        HttpServletRequest request = (HttpServletRequest) servletRequest; // 将ServletRequest强制转换为HttpServletRequest类型，以便获取更多信息。
        HttpServletResponse response = (HttpServletResponse) servletResponse; // 将ServletResponse强制转换为HttpServletResponse类型，以便设置更多信息。
        HttpSession session = request.getSession(); // 获取请求的会话对象。
        User user = (User) session.getAttribute("user"); // 从会话中获取用户属性，并强制转换为User类型。
        if (user == null) { // 如果用户属性为null，表示未登录状态。
            response.sendRedirect(request.getContextPath() + "/login"); // 重定向到登录页面
        }
        else { // 如果用户属性不为null，表示已登录状态。
            filterChain.doFilter(request, response); // 放行请求，继续执行后续的过滤器或控制器。
        }
    }

    @Override
    public void destroy() {
        // 销毁过滤器时调用该方法，可以在这里做一些清理或释放资源的工作。
    }
}

