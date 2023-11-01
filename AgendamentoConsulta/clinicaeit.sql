-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Oct 01, 2023 at 09:12 PM
-- Server version: 10.4.28-MariaDB
-- PHP Version: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

create database `clinicaeit`;

use `clinicaeit`;
--
-- Database: `clinicaeit`
--

-- --------------------------------------------------------

--
-- Table structure for table `consulta`
--

CREATE TABLE `consulta` (
  `ID` int(11) NOT NULL,
  `DataConsulta` date DEFAULT NULL,
  `PacienteID` int(11) DEFAULT NULL,
  `MedicoID` int(11) DEFAULT NULL,
  `ConsultaStatus` varchar(20) DEFAULT NULL,
  `Observacao` text DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `funcionario`
--

CREATE TABLE `funcionario` (
  `ID` int(11) NOT NULL,
  `Especialidade` varchar(255) DEFAULT NULL,
  `CRM` varchar(20) DEFAULT NULL,
  `Cargo` varchar(50) DEFAULT NULL,
  `DataContratacao` date DEFAULT NULL,
  `Salario` decimal(10,2) DEFAULT NULL,
  `Nome` varchar(60) NOT NULL,
  `DataNascimento` date DEFAULT NULL,
  `Genero` enum('Masculino','Feminino') DEFAULT NULL,
  `Nacionalidade` varchar(50) DEFAULT NULL,
  `Endereco` varchar(255) DEFAULT NULL,
  `Email` varchar(255) DEFAULT NULL,
  `Celular` varchar(20) DEFAULT NULL,
  `Status` varchar(20) DEFAULT NULL,
  `Observacao` text DEFAULT NULL,
  `TipoUsuarioID` int(11) DEFAULT NULL,
  `HorarioTrabalho` varchar(50) DEFAULT NULL,
  `LoginName` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `funcionario`
--

INSERT INTO `funcionario` (`ID`, `Especialidade`, `CRM`, `Cargo`, `DataContratacao`, `Salario`, `Nome`, `DataNascimento`, `Genero`, `Nacionalidade`, `Endereco`, `Email`, `Celular`, `Status`, `Observacao`, `TipoUsuarioID`, `HorarioTrabalho`, `LoginName`) VALUES
(1000, NULL, NULL, NULL, '2023-09-27', 113000.30, 'Joao Mateus', '1973-09-05', 'Masculino', 'Mocambicano', 'Cidade da Matola', 'joao.mateus@clinicaeit.co.mz', NULL, NULL, NULL, 3, NULL, 'JMateus1'),
(1001, 'Cardiologia', '1487565', 'Medico', '2023-09-27', 350000.00, 'John Rambo', '1965-09-28', 'Masculino', 'Mocambicano', 'Casa Branca', 'rambo@clinicaeit.co.mz', NULL, NULL, NULL, 1, NULL, 'JRambo1');

-- --------------------------------------------------------

--
-- Table structure for table `historicomedico`
--

CREATE TABLE `historicomedico` (
  `IDHistoricoMedico` int(11) NOT NULL,
  `IDPaciente` int(11) DEFAULT NULL,
  `IDMedico` int(11) DEFAULT NULL,
  `DataConsulta` date DEFAULT NULL,
  `Diagnostico` text DEFAULT NULL,
  `Tratamento` text DEFAULT NULL,
  `ResultadosExames` text DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `paciente`
--

CREATE TABLE `paciente` (
  `ID` int(11) NOT NULL,
  `LoginName` varchar(10) DEFAULT NULL,
  `Nome` varchar(255) NOT NULL,
  `NumeroSeguroSaude` varchar(20) DEFAULT NULL,
  `DataNascimento` date DEFAULT NULL,
  `Genero` enum('Masculino','Feminino') DEFAULT NULL,
  `Nacionalidade` varchar(50) DEFAULT NULL,
  `Endereco` varchar(255) DEFAULT NULL,
  `Email` varchar(255) DEFAULT NULL,
  `Celular` varchar(20) DEFAULT NULL,
  `Status` varchar(20) DEFAULT NULL,
  `Observacao` text DEFAULT NULL,
  `TipoUsuarioID` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `paciente`
--

INSERT INTO `paciente` (`ID`, `LoginName`, `Nome`, `NumeroSeguroSaude`, `DataNascimento`, `Genero`, `Nacionalidade`, `Endereco`, `Email`, `Celular`, `Status`, `Observacao`, `TipoUsuarioID`) VALUES
(999999, 'CJ01', 'Carl Jonson', '547821235', '1998-01-01', 'Masculino', 'Mocambicano', NULL, NULL, '+2584552562', NULL, NULL, 2);

-- --------------------------------------------------------

--
-- Table structure for table `tipoperfil`
--

CREATE TABLE `tipoperfil` (
  `ID` int(11) NOT NULL,
  `NomePerfil` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `tipoperfil`
--

INSERT INTO `tipoperfil` (`ID`, `NomePerfil`) VALUES
(1, 'medico'),
(2, 'paciente'),
(3, 'admin');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `consulta`
--
ALTER TABLE `consulta`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `PacienteID` (`PacienteID`),
  ADD KEY `MedicoID` (`MedicoID`);

--
-- Indexes for table `funcionario`
--
ALTER TABLE `funcionario`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `TipoUsuarioID` (`TipoUsuarioID`);

--
-- Indexes for table `historicomedico`
--
ALTER TABLE `historicomedico`
  ADD PRIMARY KEY (`IDHistoricoMedico`),
  ADD KEY `IDPaciente` (`IDPaciente`),
  ADD KEY `IDMedico` (`IDMedico`);

--
-- Indexes for table `paciente`
--
ALTER TABLE `paciente`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `TipoUsuarioID` (`TipoUsuarioID`);

--
-- Indexes for table `tipoperfil`
--
ALTER TABLE `tipoperfil`
  ADD PRIMARY KEY (`ID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `consulta`
--
ALTER TABLE `consulta`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `funcionario`
--
ALTER TABLE `funcionario`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=1002;

--
-- AUTO_INCREMENT for table `historicomedico`
--
ALTER TABLE `historicomedico`
  MODIFY `IDHistoricoMedico` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `paciente`
--
ALTER TABLE `paciente`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=1000000;

--
-- AUTO_INCREMENT for table `tipoperfil`
--
ALTER TABLE `tipoperfil`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `consulta`
--
ALTER TABLE `consulta`
  ADD CONSTRAINT `consulta_ibfk_1` FOREIGN KEY (`PacienteID`) REFERENCES `paciente` (`ID`),
  ADD CONSTRAINT `consulta_ibfk_2` FOREIGN KEY (`MedicoID`) REFERENCES `funcionario` (`ID`);

--
-- Constraints for table `funcionario`
--
ALTER TABLE `funcionario`
  ADD CONSTRAINT `funcionario_ibfk_1` FOREIGN KEY (`TipoUsuarioID`) REFERENCES `tipoperfil` (`ID`);

--
-- Constraints for table `historicomedico`
--
ALTER TABLE `historicomedico`
  ADD CONSTRAINT `historicomedico_ibfk_1` FOREIGN KEY (`IDPaciente`) REFERENCES `paciente` (`ID`),
  ADD CONSTRAINT `historicomedico_ibfk_2` FOREIGN KEY (`IDMedico`) REFERENCES `funcionario` (`ID`);

--
-- Constraints for table `paciente`
--
ALTER TABLE `paciente`
  ADD CONSTRAINT `paciente_ibfk_1` FOREIGN KEY (`TipoUsuarioID`) REFERENCES `tipoperfil` (`ID`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
