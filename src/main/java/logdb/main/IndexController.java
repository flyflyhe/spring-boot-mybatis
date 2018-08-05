package logdb.main;

import logdb.tool.Tool;
import logdb.tool.ToolFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@ComponentScan("logdb.*")
public class IndexController {

    @Autowired
    private Tool tool;

    @RequestMapping("/")
    public int index() {
        return tool.getId();
    }
}