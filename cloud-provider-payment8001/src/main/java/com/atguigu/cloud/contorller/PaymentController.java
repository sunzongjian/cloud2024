package com.atguigu.cloud.contorller;

import com.atguigu.cloud.entities.Pay;
import com.atguigu.cloud.entities.PayDTO;
import com.atguigu.cloud.service.PaymentService;
import jakarta.annotation.Resource;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PaymentController {
    @Resource
    private PaymentService paymentService;

    @PostMapping("/pay/add")
    public String add(@RequestBody Pay pay) {
        System.out.println(pay.toString());
        int i = paymentService.add(pay);
        return "成功插入记录，返回值：" + i;
    }

    @DeleteMapping("/pay/delete/{id}")
    public String delete(@PathVariable("id") Integer id) {
        return "成功删除记录，返回值" + paymentService.delete(id);
    }

    @PutMapping("/pay/update")
    public String update(@RequestBody PayDTO payDTO) {
        Pay pay = new Pay();
        BeanUtils.copyProperties(payDTO, pay);
        return "成功修改记录，返回值：" + paymentService.update(pay);
    }

    @GetMapping("/pay/get/{id}")
    public Pay getById(@PathVariable("id") Integer id) {
        return paymentService.getById(id);
    }

    @GetMapping("/pay/getAll")
    public List<Pay> getAll() {
        return paymentService.getAll();
    }
}
