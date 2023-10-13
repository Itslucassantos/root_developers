package com.root_developers.calculador.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonView;
import com.root_developers.calculador.models.AddressModel;
import com.root_developers.calculador.models.LegalClientModel;
import com.root_developers.calculador.models.PhysicalClientModel;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.beans.BeanUtils;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ClientDataDto {
    public interface ClientView {
        public static interface LegalClient {}
        public static interface PhysicalClient{}
    }

    @JsonView({ClientView.LegalClient.class, ClientView.PhysicalClient.class})
    private UUID id;

    @NotBlank(groups = ClientView.LegalClient.class)
    @JsonView(ClientView.LegalClient.class)
    private String socialReason;

    @NotBlank(groups = ClientView.LegalClient.class)
    @JsonView(ClientView.LegalClient.class)
    private String cnpj;

    @NotBlank(groups = {ClientView.LegalClient.class, ClientView.PhysicalClient.class})
    @JsonView({ClientView.LegalClient.class, ClientView.PhysicalClient.class})
    protected String firstName;

    @NotBlank(groups = {ClientView.LegalClient.class, ClientView.PhysicalClient.class})
    @JsonView({ClientView.LegalClient.class, ClientView.PhysicalClient.class})
    protected String surname;

    @NotBlank(groups = {ClientView.LegalClient.class, ClientView.PhysicalClient.class})
    @JsonView({ClientView.LegalClient.class, ClientView.PhysicalClient.class})
    @Email
    protected String email;

    @NotBlank(groups = {ClientView.LegalClient.class, ClientView.PhysicalClient.class})
    @JsonView({ClientView.LegalClient.class, ClientView.PhysicalClient.class})
    @Email
    protected String confirmEmail;

    @NotBlank(groups = {ClientView.LegalClient.class, ClientView.PhysicalClient.class})
    @JsonView({ClientView.LegalClient.class, ClientView.PhysicalClient.class})
    protected String cpf;

    @NotBlank(groups = {ClientView.LegalClient.class, ClientView.PhysicalClient.class})
    @JsonView({ClientView.LegalClient.class, ClientView.PhysicalClient.class})
    protected String phoneNumber;

    @NotBlank(groups = {ClientView.LegalClient.class, ClientView.PhysicalClient.class})
    @JsonView({ClientView.LegalClient.class, ClientView.PhysicalClient.class})
    protected String password;

    @NotBlank(groups = {ClientView.LegalClient.class, ClientView.PhysicalClient.class})
    @JsonView({ClientView.LegalClient.class, ClientView.PhysicalClient.class})
    protected String confirmPassword;

    @JsonView({ClientView.LegalClient.class, ClientView.PhysicalClient.class})
    private AddressModel address;

    public ClientDataDto(LegalClientModel legalClientModel) {
        BeanUtils.copyProperties(legalClientModel, this);
    }
    public ClientDataDto(PhysicalClientModel physicalClientModel) {BeanUtils.copyProperties(physicalClientModel, this);}

}
