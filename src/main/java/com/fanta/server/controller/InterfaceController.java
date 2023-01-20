package com.fanta.server.controller;

import com.fanta.server.common.ResponseData;
import com.fanta.server.model.dto.interfaces.InterfaceInsertParam;
import com.fanta.server.service.IInterfaceService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 接口web层
 *
 * @author mmsong
 */
@RestController
@RequestMapping("interface")
public class InterfaceController extends BaseController {

    private final IInterfaceService interfaceService;

    public InterfaceController(IInterfaceService interfaceService) {
        this.interfaceService = interfaceService;
    }

    @PostMapping
    private ResponseData<String> insert(@Validated @RequestBody InterfaceInsertParam param) {
        return ResponseData.succeed();
    }
}
