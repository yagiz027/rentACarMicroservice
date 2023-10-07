package com.yagiz.inventoryservice.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import com.yagiz.commonservice.utils.ModelMapper.ModelMapperService;
import com.yagiz.commonservice.utils.RestExceptionHandler.exceptions.BusinessException;
import com.yagiz.inventoryservice.business.abstracts.BrandService;
import com.yagiz.inventoryservice.business.dtos.requests.create.CreateBrandRequest;
import com.yagiz.inventoryservice.business.dtos.requests.update.UpdateBrandRequest;
import com.yagiz.inventoryservice.business.dtos.responses.create.CreateBrandResponse;
import com.yagiz.inventoryservice.business.dtos.responses.get.GetBrandListResponse;
import com.yagiz.inventoryservice.business.dtos.responses.get.GetBrandResponse;
import com.yagiz.inventoryservice.business.dtos.responses.update.UpdateBrandResponse;
import com.yagiz.inventoryservice.business.rules.BrandBusinessRules;
import com.yagiz.inventoryservice.entity.Brand;
import com.yagiz.inventoryservice.repository.BrandRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class BrandManager implements BrandService {
    private final BrandRepository repository;
    private final ModelMapperService modelMapperService;
    private final BrandBusinessRules rules;

    @Override
    public CreateBrandResponse add(CreateBrandRequest createBrandRequest) {
        Brand brand = modelMapperService.forRequest().map(createBrandRequest, Brand.class);
        repository.save(brand);
        CreateBrandResponse response = modelMapperService.forResponse().map(brand, CreateBrandResponse.class);
        return response;
    }

    @Override
    public UpdateBrandResponse update(int id, UpdateBrandRequest request) {
        rules.ifBrandNotExists(id);
        Brand brand = modelMapperService.forResponse().map(request, Brand.class);
        brand.setId(id);
        repository.save(brand);
        UpdateBrandResponse response = modelMapperService.forResponse().map(brand, UpdateBrandResponse.class);
        return response;
    }

    @Override
    public GetBrandResponse getBrandById(int brandId) {
        Brand brand = repository.findById(brandId).orElseThrow(() -> new BusinessException(
                com.yagiz.commonservice.utils.RestExceptionHandler.constants.Messages.Brand.NotExists));
        GetBrandResponse response = modelMapperService.forResponse().map(brand, GetBrandResponse.class);
        return response;
    }

    @Override
    public List<GetBrandListResponse> getBrandList() {
        List<Brand> brandList = repository.findAll();
        List<GetBrandListResponse> response = brandList.stream()
                .map(brand -> modelMapperService
                        .forResponse().map(brand, GetBrandListResponse.class))
                .toList();
        return response;
    }

    @Override
    public void deleteBrandById(int brandId) {
        rules.ifBrandNotExists(brandId);
        repository.deleteById(brandId);
    }
}
