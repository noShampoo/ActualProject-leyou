package per.bhj.leyou.item.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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

//    /**
//     * 查询参数集合
//     * @param gid
//     * @param cid
//     * @return
//     */
//    @GetMapping("param")
//    public ResponseEntity<List<Specification>> queryParamByList(
//            @RequestParam(value = "gid", required = false) Long gid,
//            @RequestParam(value = "cid", required = false) Long cid) {
//        return ResponseEntity.ok(specificationService.queryParamByList(gid, cid))
//    }
}
