defmodule SecretHandshake do
  @doc """
  Determine the actions of a secret handshake based on the binary
  representation of the given `code`.

  If the following bits are set, include the corresponding action in your list
  of commands, in order from lowest to highest.

  1 = wink
  10 = double blink
  100 = close your eyes
  1000 = jump

  10000 = Reverse the order of the operations in the secret handshake
  """
  @spec commands(code :: integer) :: list(String.t())
  def commands(code) do

    actions = ["wink", "double blink", "close your eyes", "jump"]

    encode = Integer.to_charlist(code, 2)
    |> Enum.take(-5)
    |> Enum.reverse()

    decode = Enum.filter(actions,
    fn(x) -> Enum.at(encode, Enum.find_index(actions, &(&1 == x)), ?0) == ?1 end)

    if Enum.at(encode, 4, ?0) == ?1 do
      Enum.reverse(decode)
    else
      decode
    end
  end
end
