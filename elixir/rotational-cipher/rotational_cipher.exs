defmodule RotationalCipher do
  @doc """
  Given a plaintext and amount to shift by, return a rotated string.

  Example:
  iex> RotationalCipher.rotate("Attack at dawn", 13)
  "Nggnpx ng qnja"
  """
  @spec rotate(text :: String.t(), shift :: integer) :: String.t()
  def rotate(text, shift) do
    String.to_charlist(text) |> Enum.map(fn(x) -> shift_c(x, shift) end) |> to_string()
  end

  @spec shift_c(character :: char, shift :: integer) :: char
  defp shift_c(char, shift) do
    cond do
      (char >= ?a and char <= ?z and char + shift <= ?z) -> char + shift
      (char >= ?a and char <= ?z) -> char + shift - 26
      (char >= ?A and char <= ?Z and char + shift <= ?Z) -> char + shift
      (char >= ?A and char <= ?Z) -> char + shift - 26
      true -> char
    end
  end
end
