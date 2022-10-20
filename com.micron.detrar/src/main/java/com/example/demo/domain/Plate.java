package com.example.demo.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.example.demo.domain.enums.PlateType;
import com.example.demo.domain.services.BrazilPlateService;
import com.example.demo.domain.services.PlateService;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="TB_PLATE")
public class Plate {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name="Valor")
	private String plateValue;
	
	@OneToOne(mappedBy = "plate")
	@JoinColumn(name="Id_veiculo")
	@JsonIgnore
	private Vehicle vehicleId;
	
	@Column
	private String location;
	
	@Enumerated(EnumType.STRING	)
	@Column(name="Tipo_de_placa")
	PlateType type;


	public Plate(String location, PlateService service) {
		
		this.location = location;
		
		plateValue = service.generatedPlate();
		if(service instanceof BrazilPlateService) {
			type = PlateType.BRAZIL_PLATE;
			this.location = location;
		}else {
			type = PlateType.MERCOSUL_PLATE;
			this.location = "BR";
		}
		
	}
	
	
	
	
}
