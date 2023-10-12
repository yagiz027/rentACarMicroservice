package com.yagiz.inventoryservice.api;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.yagiz.inventoryservice.business.abstracts.BrandService;
import com.yagiz.inventoryservice.business.dtos.requests.create.CreateBrandRequest;
import com.yagiz.inventoryservice.business.dtos.requests.update.UpdateBrandRequest;
import com.yagiz.inventoryservice.business.dtos.responses.create.CreateBrandResponse;
import com.yagiz.inventoryservice.business.dtos.responses.get.GetBrandListResponse;
import com.yagiz.inventoryservice.business.dtos.responses.get.GetBrandResponse;
import com.yagiz.inventoryservice.business.dtos.responses.update.UpdateBrandResponse;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/brands")
public class BrandController {
    private final BrandService brandService;

    @PostMapping
    public CreateBrandResponse add(@Valid @RequestBody CreateBrandRequest request) {
        return brandService.add(request);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public UpdateBrandResponse update(@PathVariable int id, @RequestBody UpdateBrandRequest request) {
        return brandService.update(id, request);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public GetBrandResponse getModelById(@PathVariable int id) {
        return brandService.getBrandById(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<GetBrandListResponse> getBrandList() {
        return brandService.getBrandList();
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBrandById(@PathVariable int id) {
        brandService.deleteBrandById(id);
    }
}
