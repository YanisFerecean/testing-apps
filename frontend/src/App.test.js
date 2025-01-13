import { render, screen, waitFor } from '@testing-library/react';
import App from './App';

// Mocking the global fetch function
global.fetch = jest.fn();

describe('App Component', () => {
  it('displays a list of persons', async () => {
    // Mock API response
    fetch.mockResolvedValueOnce({
      ok: true,
      json: async () => [
        { id: 1, name: 'John Doe', age: 30 },
        { id: 2, name: 'Jane Doe', age: 25 },
      ],
    });

    render(<App />);

    // Wait for the data to load and appear on the screen
    await waitFor(() => screen.getByText(/John Doe/));

    expect(screen.getByText(/John Doe/)).toBeInTheDocument();
    expect(screen.getByText(/Jane Doe/)).toBeInTheDocument();
  });
});
