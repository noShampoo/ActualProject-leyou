package per.bhj.leyou.item.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import per.bhj.leyou.item.pojo.Specification;
import per.bhj.leyou.item.service.SpecificationService;

import java.util.List;

@RestController
@RequestMapping("spec")
public class SpecificationController {

    @Autowired
    private SpecificationService specificationService;

    @GetMapping("groups/{id}")
    public ResponseEntity<List<Specification>> querySpecificationById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(specificationService.querySpecificationById(id));
    }
}
