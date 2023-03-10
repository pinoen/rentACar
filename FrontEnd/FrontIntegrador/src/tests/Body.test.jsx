import { fireEvent, render, screen } from '@testing-library/react';
import Body from '../components/pages/Body'
import matchers from "@testing-library/jest-dom/matchers";
import { MemoryRouter } from 'react-router-dom';
import axios from 'axios';
import { act } from 'react-dom/test-utils';
import BodyContextProvider from '../components/contexts/BodyContext';

expect.extend(matchers);

beforeEach(() => {
  render(<BodyContextProvider><Body /></BodyContextProvider>, { wrapper: MemoryRouter })
})

it("debe mostrar componente de busqueda", () => {
  const motto = screen.getByText(/encontra el vehiculo ideal/i);
  expect(motto).toBeInTheDocument();
})

it("debe mostrar componente que lista los vehiculos", () => {
  const motto = screen.getByText(/tipo de vehiculo/i);
  expect(motto).toBeInTheDocument();
})

it('deben mostrar modelo Amarok', async () => {
  const carModel = await screen.findByText(/amarok/i)
  expect(carModel.textContent).toBe("Volkswagen Amarok")
})

const fetchData = () => axios.get("http://localhost:5000/cars")

it('el primer modelo de auto que debe renderizarse el el listado es Chevrolet Classic', async () => {
  await act(async () => {
    const res = await fetchData();
    expect(res.data[0].name).toBe("Chevrolet Classic");
  })
})

it('listado de vehiculos debe mostrar el total de vehiculos disponibles en api', async () => {
  const carCards = await screen.findAllByTestId("car-card")
  return fetchData().then(res => {
    expect(res.data.length).toBe(carCards.length)
  })
})

