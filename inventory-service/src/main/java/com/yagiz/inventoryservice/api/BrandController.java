package com.yagiz.inventoryservice.api;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.yagiz.inventoryservice.business.abstracts.BrandService;
import com.yagiz.inventoryservice.business.dtos.requests.create.CreateBrandRequest;
import com.yagiz.inventoryservice.business.dtos.requests.update.UpdateBrandRequest;
import com.yagiz.inventoryservice.business.dtos.responses.create.CreateBrandResponse;
import com.yagiz.inventoryservice.business.dtos.responses.get.GetBrandListResponse;
import com.yagiz.inventoryservice.business.dtos.responses.get.GetBrandResponse;
import com.yagiz.inventoryservice.business.dtos.responses.update.UpdateBrandResponse;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class BrandController {
    private final BrandService brandService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CreateBrandResponse add(@RequestParam CreateBrandRequest request) {
        return brandService.add(request);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public UpdateBrandResponse update(@PathVariable int id, @RequestParam UpdateBrandRequest request) {
        return brandService.update(id, request);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public GetBrandResponse getModelById(@PathVariable int brandId) {
        return brandService.getBrandById(brandId);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<GetBrandListResponse> getBrandList() {
        return brandService.getBrandList();
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBrandById(int brandId) {
        brandService.deleteBrandById(brandId);
    }
}
