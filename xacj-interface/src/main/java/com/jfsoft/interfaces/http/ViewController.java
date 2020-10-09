package com.jfsoft.interfaces.http;

import com.jfsoft.interfaces.utils.R;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author chenxc
 * @email 997909544@qq.com
 * @date 2020/4/1  17:43
 */
@Controller
public class ViewController {

    @Value("${app.version}")
    private String version;

    @RequestMapping({"", "/"})
    public String login(Model model) {
        model.addAttribute("version", version);
        return "login";
    }

    @RequestMapping("/index")
    public String index() {
        return "index";
    }

    @RequestMapping("/task")
    public String task() {
        return "task";
    }

    @RequestMapping("/log")
    public String log() {
        return "log";
    }

    @GetMapping("/version")
    @ResponseBody
    public R getVersion() {
        return R.ok().put("data", "v" + version);
    }
}
